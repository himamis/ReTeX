//
//  FontI.m
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import "FontI.h"

NSMutableDictionary* fontDictionary;
@implementation FontI
@synthesize mCTFont = _mCTFont;
-(id)initWithName:(NSString *)name withStyle:(int)sty withSize:(int)s
{
    if(fontDictionary == nil){
        fontDictionary = [NSMutableDictionary dictionaryWithCapacity:4];
    }
    size = s;
    style = sty;
    //NSLog(@"name :%@",name);
    CTFontRef tmp = (__bridge CTFontRef)([fontDictionary objectForKey:name]);
    if(tmp == nil){
        _mCTFont = CTFontCreateWithName((CFStringRef)name, size, nil);
        [fontDictionary setObject:(__bridge id _Nonnull)(_mCTFont) forKey:name];
    }else{
        _mCTFont = tmp;
    }
    
    //NSLog(@"font name: %@, size: %d", name, size);
    //_mUIFont = [UIFont fontWithName:name size:s];
    return self;
}
@end
