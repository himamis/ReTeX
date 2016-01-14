//
//  BasicStrokeI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "BasicStrokeI.h"

@implementation BasicStrokeI
-(id)initWithWidth:(float)width withMiterLimit:(float)miterLimit withCap:(int)cap withJoin:(int)join
{
    mWidth = width;
    mMiterLimit = miterLimit;
    mCap = cap;
    mJoin = join;
    return self;
}

-(id)initWithWidth:(float)width withMiterLimit:(float)miterLimit withCGCap:(CGLineCap)cap withCGJoin:(CGLineJoin)join
{
    return [self initWithWidth:width withMiterLimit:miterLimit withCap:getCap(cap) withJoin:getJoin(join)];
}

-(float)getWidth
{
    return mWidth;
}

-(float)getMiterLimit
{
    return mMiterLimit;
}

-(CGLineCap)getNativeCap
{
    switch (mCap) {
        case RXBasicStroke_CAP_BUTT:
            return kCGLineCapButt;
            break;
        case RXBasicStroke_CAP_ROUND:
            return kCGLineCapRound;
            break;
        case RXBasicStroke_CAP_SQUARE:
            return kCGLineCapSquare;
        default:
            return kCGLineCapButt;
            break;
    }
}

-(CGLineJoin)getNativeJoin
{
    switch (mJoin) {
        case RXBasicStroke_JOIN_BEVEL:
            return kCGLineJoinBevel;
            break;
        case RXBasicStroke_JOIN_MITER:
            return kCGLineJoinMiter;
            break;
        case RXBasicStroke_JOIN_ROUND:
            return kCGLineJoinRound;
            break;
        default:
            return kCGLineJoinBevel;
            break;
    }
}


@end

int getCap(CGLineCap cap)
{
    switch (cap) {
        case kCGLineCapButt:
            return RXBasicStroke_CAP_BUTT;
            break;
        case kCGLineCapRound:
            return RXBasicStroke_CAP_ROUND;
            break;
        case kCGLineCapSquare:
            return RXBasicStroke_CAP_SQUARE;
            break;
        default:
            return RXBasicStroke_CAP_BUTT;
            break;
    }
}

int getJoin(CGLineJoin join)
{
    switch (join) {
        case kCGLineJoinBevel:
            return RXBasicStroke_JOIN_BEVEL;
            break;
        case kCGLineJoinMiter:
            return RXBasicStroke_JOIN_MITER;
            break;
        case kCGLineJoinRound:
            return RXBasicStroke_JOIN_ROUND;
            break;
        default:
            return RXBasicStroke_JOIN_BEVEL;
            break;
    }
}










