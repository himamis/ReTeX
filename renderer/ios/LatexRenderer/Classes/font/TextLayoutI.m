//
//  TextLayoutI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "TextLayoutI.h"
#import "Graphics2DI.h"

@implementation TextLayoutI
@synthesize mFont = _mFont;
@synthesize mNSString = _mNSString;
-(instancetype)initWithString:(NSString *)string withFont:(FontI *)font
{
    _mFont = font;
    _mNSString = string;
    return self;
}
-(void)drawWithRXGraphics2DInterface:(id<RXGraphics2DInterface>)graphics withInt:(jint)x withInt:(jint)y
{
    Graphics2DI* g2d = (Graphics2DI*)graphics;
    [g2d drawStringWithString:_mNSString withX:x withY:y];
}
@end
