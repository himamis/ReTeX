//
//  ImageI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Image.h"
#import <CoreGraphics/CoreGraphics.h>
#import <UIKit/UIKit.h>
@interface ImageI : NSObject<RXImage>
@property CGContextRef mCGContext;
@property CGImageRef mCGImage;
-(instancetype)initWithWidth:(int)width withHeight:(int)height;
-(UIImage*)getImage;
-(CGImageRef)getCGImage;
@end
