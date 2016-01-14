//
//  Point2DI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Point2D.h"
#import <CoreGraphics/CoreGraphics.h>

@interface Point2DI : NSObject <RXPoint2D>
@property CGPoint point;
-(id)initWithX:(double)x withY:(double)y;
@end
