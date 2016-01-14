#
#  Be sure to run `pod spec lint LatexRenderer.podspec' to ensure this is a
#  valid spec and to remove all comments including this before submitting the spec.
#
#  To learn more about Podspec attributes see http://docs.cocoapods.org/specification.html
#  To see working Podspecs in the CocoaPods repo see https://github.com/CocoaPods/Specs/
#

Pod::Spec.new do |s|

  s.name         = "LatexRenderer"
  s.version      = "1.0"
  s.summary      = "JLaTeXMath based LaTeX renderer"

  s.homepage     = "http://github.com/himamis/ReTeX.git"

  s.resources    = 'LatexRenderer/Resources/**/*'
  s.requires_arc = true

  s.source_files  = "LatexRenderer/Classes", "Classes/**/*.{h,m}"
  
  s.ios.deployment_target = '8.3'

end
