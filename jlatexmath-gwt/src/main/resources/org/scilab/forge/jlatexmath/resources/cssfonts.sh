CSSSTRING=`cat defaultfontface.txt`;

CSSFILENAME="webfonts.css";

cat cssheader.txt > $CSSFILENAME;

for fontFolder in `find . -type f -name '*.woff' | sed -r 's|/[^/]+$||' | sort | uniq`;do
    for fontName in `ls $fontFolder | cut -d"." -f1 | sort | uniq`;do
        echo $CSSSTRING | sed -e 's/my-font-name/'$fontName'/g' >> $CSSFILENAME
    done
done

