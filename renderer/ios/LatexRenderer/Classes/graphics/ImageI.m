//
//  ImageI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "ImageI.h"
#import "Graphics2DI.h"
#import <UIKit/UIKit.h>

@implementation ImageI
@synthesize mCGContext = _mCGContext;
@synthesize mCGImage = _mCGImage;
-(instancetype)initWithWidth:(int)width withHeight:(int)height
{
    CGColorSpaceRef colorSpace = CGColorSpaceCreateDeviceRGB();
    float scale = [UIScreen mainScreen].scale;
    _mCGContext = CGBitmapContextCreate(nil, width * scale, height * scale, 8, width*4 * scale, colorSpace, kCGImageAlphaPremultipliedFirst);
    //_mCGImage = CGBitmapContextCreateImage(_mCGContext);
    CGColorSpaceRelease(colorSpace);
    //CGContextTranslateCTM(_mCGContext, 0, height);
    //CGContextScaleCTM(_mCGContext, 1, -1);
    CGContextSetTextMatrix(_mCGContext, CGAffineTransformMake(1, 0, 0, -1, 0, height * scale));
    CGContextScaleCTM(_mCGContext, 1/scale, 1/scale);
    return self;
}
-(id<RXGraphics2DInterface>)createGraphics2D
{
    return [[Graphics2DI alloc] initWithContext:_mCGContext];
}
-(UIImage*)getImage
{
    _mCGImage = CGBitmapContextCreateImage(_mCGContext);
    return [UIImage imageWithCGImage:_mCGImage];
}

-(CGImageRef)getCGImage
{
    _mCGImage = CGBitmapContextCreateImage(_mCGContext);
    return _mCGImage;
}

-(jint)getWidth
{
    return (int)CGImageGetWidth(_mCGImage);
}

-(jint)getHeight
{
    return (int)CGImageGetHeight(_mCGImage);
}

@end
