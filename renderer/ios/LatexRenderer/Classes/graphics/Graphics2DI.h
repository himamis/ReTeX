//
//  Graphics2DI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Graphics2DInterface.h"
#import "FontI.h"
#import "ColorI.h"
#import "BasicStrokeI.h"
#import <CoreGraphics/CoreGraphics.h>
@interface Graphics2DI : NSObject <RXGraphics2DInterface>
@property CGContextRef mCGContext;
@property CGRect mFrame;
@property(retain) FontI* mFont;
@property(retain) ColorI* mColor;
@property(retain) BasicStrokeI* mStroke;
-initWithContext:(CGContextRef)context;
-(void)drawStringWithString:(NSString*)string withX:(int)x withY:(int)y;
@end
