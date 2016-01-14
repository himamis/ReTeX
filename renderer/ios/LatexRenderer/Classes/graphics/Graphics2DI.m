//
//  Graphics2DI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "Graphics2DI.h"
#import "ColorUtil.h"
#import "BasicStrokeI.h"
#import "ColorI.h"
#import "TransformI.h"
#import "FontI.h"
#import "Rectangle2DI.h"
#import "Line2DI.h"
#import "Point2D.h"
#import "ImageI.h"
#import <CoreText/CoreText.h>
#import <UIKit/UIKit.h>
#import "J2ObjC_source.h"

@implementation Graphics2DI
@synthesize mCGContext = _mCGContext;
@synthesize mFrame = _mFrame;
@synthesize mColor = _mColor;
@synthesize mFont = _mFont;
@synthesize mStroke = _mStroke;
-(id)initWithContext:(CGContextRef)context
{
    _mCGContext = context;
    _mFont = [[FontI alloc] initWithName:@"Serif" withStyle:1 withSize:12];
    _mColor = (ColorI*)RXColorUtil_BLACK_;
    return self;
}
-(void)setStrokeWithRXStroke:(id<RXStroke>)stroke
{
    BasicStrokeI* basicStroke = (BasicStrokeI*) stroke;
    CGContextSetLineCap(_mCGContext, [basicStroke getNativeCap]);
    CGContextSetLineJoin(_mCGContext, [basicStroke getNativeJoin]);
    CGContextSetMiterLimit(_mCGContext, [basicStroke getMiterLimit]);
    CGContextSetLineWidth(_mCGContext, [basicStroke getWidth]);
    _mStroke = basicStroke;
}

-(id<RXStroke>)getStroke
{
    return [[BasicStrokeI alloc] initWithWidth:[_mStroke getWidth] withMiterLimit:[_mStroke getMiterLimit] withCGCap:[_mStroke getNativeCap] withCGJoin:[_mStroke getNativeJoin]];
}

-(void)setColorWithRXColor:(id<RXColor>)color
{
    _mColor = (ColorI*)color;
    const CGFloat* com = CGColorGetComponents([_mColor impl]);
    CGContextSetStrokeColorWithColor(_mCGContext, [_mColor impl]);
    CGContextSetFillColorWithColor(_mCGContext, [_mColor impl]);
}

-(id<RXColor>)getColor
{
    return _mColor;
}

-(id<RXFont>)getFont
{
    return _mFont;
}

-(id<RXTransform>)getTransform
{
    return [[TransformI alloc] initWithCGAffineTransform: CGContextGetCTM(_mCGContext)];
}

-(void)setFontWithRXFont:(id<RXFont>)font
{
    _mFont = (FontI*)font;
}

-(void)fillRectWithInt:(jint)x withInt:(jint)y withInt:(jint)width withInt:(jint)height
{
    CGContextSaveGState(_mCGContext);
    CGContextFillRect(_mCGContext, CGRectMake(x, y, width, height));
    CGContextRestoreGState(_mCGContext);
}

-(void)fillWithRXRectangle2D:(id<RXRectangle2D>)rectangle
{
    CGContextSaveGState(_mCGContext);
    CGContextFillRect(_mCGContext, [((Rectangle2DI*)rectangle) mRect]);
    CGContextRestoreGState(_mCGContext);
}

-(void)drawWithRXRectangle2D:(id<RXRectangle2D>)rectangle
{
    CGContextSaveGState(_mCGContext);
    CGContextStrokeRect(_mCGContext, [((Rectangle2DI*)rectangle) mRect]);
    CGContextRestoreGState(_mCGContext);
}

-(void)drawWithRXLine2D:(id<RXLine2D>)line
{
    CGContextSaveGState(_mCGContext);
    Line2DI* mLine = (Line2DI*)line;
    CGPoint points[] = {[mLine startPoint], [mLine endPoint]};
    CGContextAddLines(_mCGContext, points, 2);
    CGContextStrokePath(_mCGContext);
    CGContextRestoreGState(_mCGContext);
}

-(void)drawCharsWithCharArray:(IOSCharArray *)data withInt:(jint)offset withInt:(jint)length withInt:(jint)x withInt:(jint)y
{
    CGContextSaveGState(_mCGContext);
    NSString* string = [NSString stringWithOffset:offset length:length characters:data];
    [self drawStringWithString:string withX:x withY:y];
    CGContextRestoreGState(_mCGContext);
}

-(void)drawStringWithString:(NSString *)string withX:(int)x withY:(int)y
{
    CGContextSaveGState(_mCGContext);
    //NSLog(@"String:%@ CTFontName:%@",string,CTFontCopyFullName([_mFont mCTFont]));
    NSDictionary *attributesDict = [NSDictionary dictionaryWithObjectsAndKeys:
                                    (id)[_mFont mCTFont], (id)kCTFontAttributeName,
                                    [_mColor impl], (id)kCTForegroundColorAttributeName,nil];
    CTFontDescriptorRef des =  CTFontDescriptorCreateWithAttributes((CFDictionaryRef)attributesDict);

    NSAttributedString *stringToDraw = [[NSAttributedString alloc] initWithString:string
                                                                       attributes:attributesDict];
    CTLineRef line = CTLineCreateWithAttributedString((CFAttributedStringRef)stringToDraw);
    CGContextSetTextPosition(_mCGContext, x, y);
    CTLineDraw(line, _mCGContext);
    CFRelease(line);
    //UIGraphicsPushContext(_mCGContext);
    //[string drawAtPoint:CGPointMake(x, y) withFont:[_mFont mUIFont]];
    //UIGraphicsPopContext();
    CGContextRestoreGState(_mCGContext);
}
-(void)drawArcWithInt:(jint)x withInt:(jint)y withInt:(jint)width withInt:(jint)height withInt:(jint)startAngle withInt:(jint)arcAngle
{
    ;
}

-(void)fillArcWithInt:(jint)x withInt:(jint)y withInt:(jint)width withInt:(jint)height withInt:(jint)startAngle withInt:(jint)arcAngle
{
    ;
}

-(void)translateWithDouble:(jdouble)x withDouble:(jdouble)y
{
    CGContextTranslateCTM(_mCGContext, x, y);
}

-(void)scale__WithDouble:(jdouble)x withDouble:(jdouble)y
{
    CGContextScaleCTM(_mCGContext, x, y);
}

-(void)rotateWithDouble:(jdouble)theta withDouble:(jdouble)x withDouble:(jdouble)y
{
    [self translateWithDouble:x withDouble:y];
    CGContextRotateCTM(_mCGContext, theta);
    [self translateWithDouble:-x withDouble:-y];
}

-(void)rotateWithDouble:(jdouble)theta
{
    CGContextRotateCTM(_mCGContext, theta);
}

-(void)drawImageWithRXImage:(id<RXImage>)image withInt:(jint)x withInt:(jint)y
{
    CGContextSaveGState(_mCGContext);
    ImageI* imageI = (ImageI*) image;
    CGImageRef cgimage = [imageI getCGImage];
    double width = CGImageGetWidth(cgimage);
    double height = CGImageGetHeight(cgimage);
    CGContextDrawImage(_mCGContext, CGRectMake(x, y, width, height), cgimage);
    CGContextRestoreGState(_mCGContext);
}

-(void)drawImageWithRXImage:(id<RXImage>)image withRXTransform:(id<RXTransform>)transform
{
    ;
}

-(jint)getRenderingHintWithInt:(jint)key
{
    return -1;
}

-(void)dispose
{
    ;
}

-(void)setRenderingHintWithInt:(jint)key withInt:(jint)value
{
    ;
}

-(void)saveTransformation
{
    CGContextSaveGState(_mCGContext);
}

-(void)restoreTransformation
{
    CGContextRestoreGState(_mCGContext);
}




@end
