//
//  TextLayoutI.h
//  JLaTeXMath-iOS
//
//  Created by JackyKuo on 2015/6/20.
//  Copyright (c) 2015年 JackyKuo. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "TextLayout.h"
#import "FontI.h"
@interface TextLayoutI : NSObject<RXTextLayout>
@property(retain) NSString* mNSString;
@property(retain) FontI* mFont;
-(instancetype)initWithString:(NSString*)string withFont:(FontI*)font;
@end
