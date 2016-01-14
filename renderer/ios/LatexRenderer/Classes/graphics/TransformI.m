//
//  TransformI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "TransformI.h"

@implementation TransformI
@synthesize transform = _transform;
-(instancetype)init
{
    _transform = CGAffineTransformIdentity;
    return self;
}
-(id)initWithCGAffineTransform:(CGAffineTransform)transform
{
    _transform = CGAffineTransformMake(transform.a, transform.b, transform.c, transform.d, transform.tx, transform.ty);
    return self;
}
-(jdouble)getTranslateX
{
    return _transform.tx;
}
-(jdouble)getTranslateY
{
    return _transform.ty;
}
-(jdouble)getScaleX
{
    return _transform.a;
}
-(jdouble)getScaleY
{
    return _transform.d;
}
-(jdouble)getShearX
{
    return _transform.c;
}
-(jdouble)getShearY
{
    return _transform.b;
}
-(id<RXTransform>)createClone
{
    return [[TransformI alloc] initWithCGAffineTransform:_transform];
}
-(void)scale__WithDouble:(jdouble)sx withDouble:(jdouble)sy
{
    _transform = CGAffineTransformConcat(_transform, CGAffineTransformMakeScale(sx, sy));
}
-(void)translateWithDouble:(jdouble)tx withDouble:(jdouble)ty
{
    _transform = CGAffineTransformConcat(_transform, CGAffineTransformMakeTranslation(tx, ty));
}
-(void)shearWithDouble:(jdouble)sx withDouble:(jdouble)sy
{
    ;
}
@end
