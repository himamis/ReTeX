//
//  Rectangle2DI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "Rectangle2DI.h"

@implementation Rectangle2DI
@synthesize mRect = _mRect;
-(id)initWithX:(double)x withY:(double)y withWidth:(double)w withHeight:(double)h
{
    _mRect = CGRectMake(x, y, w, h);
    return self;
}

-(void)setRectangleWithDouble:(jdouble)x withDouble:(jdouble)y withDouble:(jdouble)width withDouble:(jdouble)height
{
    _mRect = CGRectMake(x, y, width, height);
}

-(jdouble)getX
{
    return _mRect.origin.x;
}

-(jdouble)getY
{
    return _mRect.origin.y;
}

-(jdouble)getWidth
{
    return _mRect.size.width;
}

-(jdouble)getHeight
{
    return _mRect.size.height;
}
@end
