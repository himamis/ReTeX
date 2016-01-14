//
//  FontLoaderI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "FontLoaderI.h"
#import "FontI.h"

@implementation FontLoaderI
@synthesize mNSBundle = _mNSBundle;
-(id)init
{
    _mNSBundle = [NSBundle mainBundle];
    return self;
}
-(id<RXFont>)loadFontWithId:(id)fontInt withNSString:(NSString *)name
{
    NSURL* url = [NSURL URLWithString:name];
    NSArray* arry = [url pathComponents];
    NSString* fontName = (NSString*)[arry objectAtIndex:[arry count]-1];
    fontName = [fontName substringToIndex:[fontName length] - 4];
    //NSLog(@"%@",fontName);
    return [[FontI alloc] initWithName:fontName withStyle:0 withSize:1];
}
@end
