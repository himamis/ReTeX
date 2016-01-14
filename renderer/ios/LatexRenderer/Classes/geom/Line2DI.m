//
//  Line2DI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "Line2DI.h"

@implementation Line2DI
@synthesize startPoint = _startPoint;
@synthesize endPoint = _endPoint;
-(id)initWithX1:(double)x1 withY1:(double)y1 withX2:(double)x2 withY2:(double)y2
{
    _startPoint = CGPointMake(x1, y1);
    _endPoint = CGPointMake(x2, y2);
    return self;
}
-(void)setLineWithDouble:(jdouble)x1
               withDouble:(jdouble)y1
               withDouble:(jdouble)x2
               withDouble:(jdouble)y2
{
    _startPoint.x = x1;
    _startPoint.y = y1;
    _endPoint.x = x2;
    _endPoint.y = y2;
}
-(jdouble)getX1
{
    return _startPoint.x;
}
-(jdouble)getY1
{
    return _startPoint.y;
}
-(jdouble)getX2
{
    return _endPoint.x;
}
-(jdouble)getY2
{
    return _endPoint.y;
}
@end
