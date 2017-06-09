# Best Human validator for Android (developing)

Inspired by the Laravel.

This library is under development.

# Development plan

* implement core.
* implement android extension.

# Preview
![gif](https://raw.githubusercontent.com/lsxiao/rig/master/demo.gif)

# Usage
simple usage.
```java
@Rule("int||min:10|max:30")
public String age = "20";

if (Rig.check(this).isPass()) {
    ...
}
```

depend usage,depend on age value.
```java
@Rule(value = "int|min:10|max:30", name = "age")
public String age = "20";

@Rule("when_gt:age,18|length:18")
public String idNumber = "500224199204852295";

if (Rig.check(this).isPass()) {
    ...
}
```

with ButterKnife
```java

@Rule("filled|int|max:100|min:10")
@BindView(R.id.edit_content)
public EditText mEtAge;

if (Rig.check(this).isPass()) {
    ...
}
```

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

# License
Apache License, Version 2.0
