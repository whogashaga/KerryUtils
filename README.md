# KerryUtils

## Step 1
app 的 build.gradle

* `apply plugin: 'com.android.application'` 改為 `apply plugin: 'com.android.library'`
* 新增 
	* `apply plugin: 'com.github.dcendents.android-maven'`
	* `group='com.github.whogashaga'`

## Stpe 2
project 的 build.gradle
新增 `classpath "com.github.dcendents:android-maven-gradle-plugin:1.5"`