#/bin/sh

# This script generates the css file containing the @font-face declarations for the available fonts

cd ..
baseFolder=`pwd`
toolsFolder=$baseFolder/tools
fontsFolder=$baseFolder/src/main/resources/org/scilab/forge/jlatexmath/font

# Load the css template for @font-face declaration
# my-font-name -> name of the font
# my-font-url - > url of the font
cd $toolsFolder
fontFaceTemplate=`cat fontFaceTemplate.css`;
fontFaceHeader=`cat fontFaceCssHeader.css`;

# output filename
outputFilename="font-face-declarations.css";

# Go to the font resources directory
cd $fontsFolder

echo -e $fontFaceHeader > $outputFilename;

for fontFolder in `find . -type f -name '*.woff' | sed -r 's|/[^/]+$||' | sort | uniq`;do
    echo $fontFolder
    for fontName in `ls $fontFolder | cut -d"." -f1 | sort | uniq`;do
        # echo $CSSSTRING | sed -e 's/my-font-name/'$fontName'/g' >> $CSSFILENAME
    	
    	echo $fontName
    done
done

