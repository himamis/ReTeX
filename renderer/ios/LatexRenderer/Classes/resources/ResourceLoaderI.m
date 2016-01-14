//
//  ResourceLoaderI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/21.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "ResourceLoaderI.h"
#import "java/io/File.h"
#import "java/io/InputStream.h"
#import "java/io/ByteArrayInputStream.h"
#import "J2ObjC_source.h"
#import "BaseObjectHelper.h"

@implementation ResourceLoaderI
@synthesize mNSBundle = _mNSBundle;
-(instancetype)init
{
    _mNSBundle = [NSBundle mainBundle];
    return self;
}

-(JavaIoInputStream*)loadResourceWithId:(id)base withNSString:(NSString *)path
{
    //NSLog(@"before:%@",path);
    NSURL* url = [NSURL URLWithString:path];
    NSArray* arry = [url pathComponents];
    path = [_mNSBundle pathForResource:(NSString*)[arry objectAtIndex:[arry count]-1] ofType:nil];
    //NSLog(@"after:%@",path);
    JavaIoFile* f = [[JavaIoFile alloc]initWithNSString:path];
    //JavaIoFile_initWithNSString_(f, [BaseObjectHelper getPathWithNSObject:base withName:path]);
    NSData* mNSData = [NSData dataWithContentsOfFile:[f getAbsolutePath]];
    NSUInteger length = [mNSData length];
    uint8_t *bytes = malloc(sizeof(*bytes) * length);
    [mNSData getBytes:bytes length:length];
    IOSByteArray* iosByteArray = [IOSByteArray arrayWithLength:length];
    for(int i = 0 ; i < length; i++){
        [iosByteArray replaceByteAtIndex:i withByte:bytes[i]];
    }
    return [[JavaIoByteArrayInputStream alloc] initWithByteArray:iosByteArray];
}
@end
