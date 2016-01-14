//
//  BaseObjectHelper.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "BaseObjectHelper.h"
#import "CyrillicRegistration.h"
#import "GreekRegistration.h"

@implementation BaseObjectHelper
+(NSString *)getPathWithNSObject:(NSObject *)base withName:(NSString *)name
{
    NSString* ret;
    if([base isKindOfClass:[RXCyrillicRegistration class]]){
        ret = [@"cyrillic/" stringByAppendingString:name];
    }else if([base isKindOfClass:[RXGreekRegistration class]]){
        ret = [@"greek/" stringByAppendingString:name];
    }else{
        ret = name;
    }
    return ret;
}
@end
