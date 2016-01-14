//
//  FactoryProvideriOS.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/21.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "FactoryProvideriOS.h"
#import "GeomFactoryiOS.h"
#import "FontFactoryiOS.h"
#import "GraphicsFactoryiOS.h"
#import "ParserFactoryiOS.h"
#import "ResourceLoaderFactoryiOS.h"

@implementation FactoryProvideriOS

-(instancetype)init
{
    return self;
}

-(RXFontFactory *)createFontFactory
{
    return [[FontFactoryiOS alloc] init];
}
-(RXGeomFactory *)createGeomFactory
{
    return [[GeomFactoryiOS alloc] init];
}
-(RXGraphicsFactory *)createGraphicsFactory
{
    return [[GraphicsFactoryiOS alloc] init];
}
-(RXParserFactory *)createParserFactory
{
    return [[ParserFactoryiOS alloc] init];
}
-(id<RXResourceLoaderFactory>)createResourceLoaderFactory
{
    return [[ResourceLoaderFactoryiOS alloc] init];
}
@end
