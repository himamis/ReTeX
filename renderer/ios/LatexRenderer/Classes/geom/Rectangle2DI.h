//
//  Rectangle2DI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "Rectangle2D.h"
@interface Rectangle2DI : NSObject <RXRectangle2D>
@property CGRect mRect;
-(id)initWithX:(double)x withY:(double)y withWidth:(double)w withHeight:(double)h;
@end
