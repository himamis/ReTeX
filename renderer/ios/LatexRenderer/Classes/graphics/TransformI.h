//
//  TransformI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Transform.h"
#import <CoreGraphics/CoreGraphics.h>
@interface TransformI : NSObject<RXTransform>
@property CGAffineTransform transform;
-initWithCGAffineTransform:(CGAffineTransform)transform;
@end
