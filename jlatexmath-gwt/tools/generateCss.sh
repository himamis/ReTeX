#/bin/sh

# This script generates the css file containing the @font-face declarations for the available fonts

cd ..
baseFolder=`pwd`
toolsFolder=$baseFolder/tools
publicFolder=$baseFolder/src/main/resources/org/scilab/forge/jlatexmath/public
outputFolder=$baseFolder/src/main/resources/org/scilab/forge/jlatexmath/resources/css

# Load the css template for @font-face declaration
# my-font-name -> name of the font
# my-font-url - > url of the font
cd $toolsFolder
fontFaceTemplate=`cat fontFaceTemplate.css`;
fontFaceHeader=`cat fontFaceCssHeader.css`;

# output filename
outputFilename=$outputFolder/font-face-declarations.css;

# Go to the font resources directory
cd $publicFolder

echo "$fontFaceHeader" > $outputFilename;

for font in `find . -type f -name '*.ttf' | rev | cut -d"." -f2- | rev | cut -c3-`;do
	fontUrl=$font
	fontName=`basename $font`
	echo "$fontFaceTemplate" | sed -e 's@my-font-name@'$fontName'@g' -e 's@my-font-url@'$fontUrl'@g' >> $outputFilename
done
