# 最好的验证器,为Android而生

配合ButterKinfe食用,效果更佳

灵感来源于Laravel

**注意!!!** rig当前任然处于开发中,但是你可以尝试运行demo:)


# 效果预览
![gif](https://raw.githubusercontent.com/lsxiao/rig/master/demo.gif)

# 用法(由于仍然处于开发中，以下用法可能会变，以最后发布版本为准)

## 常规用法
校验String类型的成员变量
```java
@Rule("int|min:10|max:30")
public String age = "20";

if (Rig.check(this).isPass()) {
    ...
}
```

校验EditText类型的成员变量
```java
@Rule("int|min:10|max:30")
public EditTextView mEtAge;

if (Rig.check(this).isPass()) {
    ...
}
```

校验返回值为String类型的方法
```java
@Rule("int|min:10|max:30")
public String getAge(){
    ...
}

if (Rig.check(this).isPass()) {
    ...
}
```


分组校验
group
```java
final int GROUP_USER=5;

@Group(GROUP_USER)
@Rule("int||min:10|max:30")
public String age = "20";

if (Rig.check(this,GROUP_USER).isPass()) {
    ...
}
```

和ButterKnife配合使用
```java

@Rule("filled|int|max:100|min:10")
@BindView(R.id.edit_content)
public EditText mEtAge;

if (Rig.check(this).isPass()) {
    ...
}
```



## 实例
same_as规则(校验某个字段的值，需与给定值相等)
常用于密码确认字段
```java
@Rule(value = "int|min:10|max:30", name = "密码")
public EditTextView mEtPassword;

@Rule("same_as:密码")
public EditTextView mEtConfirm;

if (Rig.check(this).isPass()) {
    ...
}
```

when_gt(校验某一个字段，当目标字段大于给定的值时，才校验这条@Rule)
```java
@Rule(value = "int|min:10|max:30", name = "age")
public String age = "20";

@Rule("when_gt:age,18|length:18")
public String idNumber = "500224199204852295";

if (Rig.check(this).isPass()) {
    ...
}
```


# License
Apache License, Version 2.0
