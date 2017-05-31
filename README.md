# Human validator for Android

Inspired by the Laravel.

This library is under development.

# Development plan

* implement core.
* implement android extension.

# Usage(Developing)
simple usage.
```java
@Rule("int|between:10,30")
public String age = "20";

if (Rig.check(this).isPass()) {
    ...
}
```

depend usage,depend on age value.
```java
@Rule(value = "int|between:10,30", name = "age")
public String age = "20";

@Rule("notnull|min:3|when_eq:age,20")
public String name = "fdf";

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
@Rule("int|between:10,30")
public String age = "20";

if (Rig.check(this,GROUP_USER).isPass()) {
    ...
}
```

# License
Apache License, Version 2.0
