//
//  GeomFactoryiOS.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "GeomFactoryiOS.h"
#import "Point2DI.h"
#import "Line2DI.h"
#import "Rectangle2DI.h"
#import "RoundRectangle2DI.h"

@implementation GeomFactoryiOS
-(id<RXPoint2D>)createPoint2DWithDouble:(jdouble)x withDouble:(jdouble)y
{
    return [[Point2DI alloc] initWithX:x withY:y];
}

-(id<RXLine2D>)createLine2DWithDouble:(jdouble)x1 withDouble:(jdouble)y1 withDouble:(jdouble)x2 withDouble:(jdouble)y2
{
    return [[Line2DI alloc] initWithX1:x1 withY1:y1 withX2:x2 withY2:y2];
}

-(id<RXRectangle2D>)createRectangle2DWithDouble:(jdouble)x withDouble:(jdouble)y withDouble:(jdouble)w withDouble:(jdouble)h
{
    return [[Rectangle2DI alloc] initWithX:x withY:y withWidth:w withHeight:h];
}

-(id<RXRoundRectangle2D>)createRoundRectangle2DWithDouble:(jdouble)x withDouble:(jdouble)y withDouble:(jdouble)w withDouble:(jdouble)h withDouble:(jdouble)arcw withDouble:(jdouble)arch
{
    return [[RoundRectangle2DI alloc] init];
}
@end
