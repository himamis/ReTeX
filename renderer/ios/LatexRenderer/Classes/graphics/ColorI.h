//
//  ColorI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Color.h"
#import <CoreGraphics/CoreGraphics.h>
@interface ColorI : NSObject <RXColor>
@property CGColorRef impl;
-initWithR:(int)r withG:(int)g withB:(int)b;
@end
