# C3Faces Changelog
This is the official changelog for C3Faces JSF library.

## 1.4
This is a small enhancement release containing the following updates:

Fixes bug #2 which reflects not updating categories on dynamic changes.
Using the _axis_ attribute with categories will still keep fixed category names
until the whole diagram is reloaded.
If you want to react on dynamic changes, use the _axis_ attribute without
fixed category names and use the newly introduced _Xkey_ class to define
dynamic category names for X-axis (it is only available for X-axis).

An example for clarification:

**JSF**:

```
<c3:line id="chart" data="#{dashboardViewBean.data}" >
	<c3:axes>
		<c3:axisX type="category" />
	</c3:axes>
</c3:line>
```

**Bean**:

```
private final Data data = new Data();
...

// New dynamic view for categories on X-axis
C3ViewDataSet categoriesView = new C3ViewDataSet(getMonths());
data.getDataSets().add(categoriesView);
data.addChild(new XKey(categoriesView.getId()));
```

This is it. After new data is added, you have to refresh the C3ViewDataSet
programmatically.

## 1.3
This is a small enhancement release containing the following updates:

- Extended faces-config.xml declaring _components_ from the taglib matching
requirements defined by older versions of JSF and Spring Boot. Background
information demanding this fix can be found
[here](https://docs.oracle.com/cd/E19575-01/819-3669/bnawo/index.html).
- It is now possible to select pre-defined colors and themes for much
more harmonius colours in charts. Therefore the classes _C3Color_ and
_C3Theme_ were introduced. _C3Theme_ contains themes used in Microsoft Excel
or LibreOffice Spreadsheet. Showcase does not reflect this change so feel free
playing around with this classes.

## 1.2
Bugfix for categories

## 1.1
Added support for axis of type category. Use the new tags _axes_, _axisX_ and _axisY_ for
a clean design of your axis. You can use the following attributes on axisX and axisY:

- use _show_ with parameter false to hide the X- or Y-axis.
- use _type_ with parameter _indexed_ or _category_ to define the axis type.
- use _categories_ with an array of your defined category names. This has only an effect if _type_ is _category_.
- use _height_ to adjust the height of the axis.
- _localtime_ is supported by defining with values false or true. But the attribute has currently no effect.
localtime will be supported in an upcoming release.

Have a look at the official [showcase](http://c3faces.kivio.org) for more details on using C3Faces.

## 1.0
This is the first official release of C3Faces as forked version from Marin Linha.
Changes are done on sources to release it under Apache 2.0 license and c3.js was
changed to version 0.4.18.
