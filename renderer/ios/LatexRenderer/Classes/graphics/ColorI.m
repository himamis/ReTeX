//
//  ColorI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "ColorI.h"

@implementation ColorI
@synthesize impl = _impl;
-(id)initWithR:(int)r withG:(int)g withB:(int)b
{
    CGFloat component[] = {r/255.0, g/255.0, b/255.0, 1};
    _impl = CGColorCreate(CGColorSpaceCreateDeviceRGB(), component);
    return self;
}
@end
