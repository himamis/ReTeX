//
//  ResourceLoaderFactoryiOS.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/21.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "ResourceLoaderFactoryiOS.h"
#import "ResourceLoaderI.h"

@implementation ResourceLoaderFactoryiOS
-(id<RXResourceLoader>)createResourceLoader
{
    return [[ResourceLoaderI alloc] init];
}
@end
