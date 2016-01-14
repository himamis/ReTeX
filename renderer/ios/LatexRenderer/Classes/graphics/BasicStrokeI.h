//
//  BasicStrokeI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BasicStroke.h"
#import <CoreGraphics/CoreGraphics.h>
@interface BasicStrokeI : NSObject <RXBasicStroke>
{
    float mWidth;
    float mMiterLimit;
    int mCap;
    int mJoin;
}
-(id)initWithWidth:(float)width withMiterLimit:(float)miterLimit withCap:(int)cap withJoin:(int)join;
-(id)initWithWidth:(float)width withMiterLimit:(float)miterLimit withCGCap:(CGLineCap)cap withCGJoin:(CGLineJoin)join;
-(CGLineCap)getNativeCap;
-(CGLineJoin)getNativeJoin;
-(float)getWidth;
-(float)getMiterLimit;
@end

int getCap(CGLineCap cap);
int getJoin(CGLineJoin join);
