#/bin/sh

# This script generates the js files containing the base64 representation of the fonts

cd ..
baseFolder=`pwd`
toolsFolder=$baseFolder/tools
fontFolder=$baseFolder/src/main/resources/org/scilab/forge/jlatexmath/public/font

# Load the template
cd $toolsFolder
fontJsTemplate=`cat fontJsTemplate.js`;

# Go to the font resources directory
cd $fontFolder

for font in `find . -type f -name '*.ttf' | rev | cut -d"." -f2- | rev`;do
	fontName=`basename $font`
	fontBase64=`base64 --wrap=0 $font.ttf` # > $font.js
	echo "$fontJsTemplate" | sed -e 's@my-font-name@'$fontName'@g' -e 's@my-font-base64@'$fontBase64'@g' > $font.js
done
