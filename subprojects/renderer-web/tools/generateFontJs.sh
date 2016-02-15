#/bin/sh

# This script generates the js files containing the base64 representation of the fonts

cd ..
baseFolder=`pwd`
toolsFolder=$baseFolder/tools
fontInputFolder=$baseFolder/../desktop/src/main/resources/com/himamis/retex/renderer/desktop
fontOutputFolder=$baseFolder/src/main/resources/com/himamis/retex/renderer/web/jlatexmath/public/font

# Load the template
cd $toolsFolder
fontJsTemplate=`cat fontJsTemplate.js`;

# Go to the font resources directory
cd $fontInputFolder

for font in `find . -type f -name '*.ttf' | rev | cut -d"." -f2- | rev`;do
	fontLoc=`echo $font | cut -c2-`
	fontName=`basename $font`
	fontBase64=`base64 --wrap=0 $font.ttf` # > $font.js
	echo "$fontJsTemplate" | sed -e 's@my-font-name@'$fontName'@g' -e 's@my-font-base64@'$fontBase64'@g' > $fontOutputFolder$fontLoc.js
done
