//
//  Line2DI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "Line2D.h"

@interface Line2DI : NSObject <RXLine2D>
@property CGPoint startPoint;
@property CGPoint endPoint;
-(id)initWithX1:(double)x1 withY1:(double)y1 withX2:(double)x2 withY2:(double)y2;
@end
