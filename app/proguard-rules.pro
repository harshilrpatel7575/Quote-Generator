# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

# Volley
-keep class com.android.volley.** { *; }

# Espresso
-keep class androidx.test.espresso.** { *; }
-keepclassmembers class * {
    @androidx.test.espresso.core.internal.deps.guava.annotations.** *;
}

# AppCompat
-keep class androidx.appcompat.** { *; }
-keepclassmembers class * {
    @androidx.annotation.** *;
}

# ConstraintLayout
-keep class androidx.constraintlayout.** { *; }

# Material Components
-keep class com.google.android.material.** { *; }

# Core KTX
-keep class androidx.core.** { *; }

# JUnit
-dontwarn junit.framework.**
-dontwarn org.junit.**
-dontwarn org.hamcrest.**
-dontwarn androidx.test.internal.**
-keep class junit.framework.** { *; }
-keep class org.junit.** { *; }
-keep class org.hamcrest.** { *; }

# Test rules
-dontwarn androidx.test.**
-keep class androidx.test.** { *; }
-keep class androidx.test.ext.junit.** { *; }
-keep class androidx.test.espresso.** { *; }
