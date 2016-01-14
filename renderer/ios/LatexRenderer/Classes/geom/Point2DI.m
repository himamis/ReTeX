//
//  Point2DI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "Point2DI.h"

@implementation Point2DI
@synthesize point = _point;
-(id)initWithX:(double)x withY:(double)y
{
    _point = CGPointMake(x, y);
    return self;
}
-(jdouble)getX
{
    return _point.x;
}
-(jdouble)getY
{
    return _point.y;
}
-(void)setXWithDouble:(jdouble)x
{
    _point.x = x;
}
-(void)setYWithDouble:(jdouble)y
{
    _point.y = y;
}
@end
