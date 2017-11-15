# SwipeableCalendarStrip
Easy to use scrollable, horizontal calendar strip component library for Android, written in Kotlin

## Prerequisites
The minimum API level supported by this library is **API 17**.

## Usage
Add SwipeableCalendarStripView to your layout file:
```xml
<com.forbroteam.calendarstrip.SwipeableCalendarStripView
        android:id="@+id/cv_calendar_strip"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#5a31ac" />
```  

Then setup SwipeableCalendarStrip in your Activity or Fragment through its **Builder**:

### Java
```java
SwipeableCalendarStrip calendarStrip = 
        new SwipeableCalendarStrip.Builder(view, R.id.cv_calendar_strip).build();
```
### Kotlin
```kotlin
val calendarStrip = SwipeableCalendarStrip.Builder(view!!, R.id.cv_calendar_strip).build()
```

Then set a listener:

### Java
```java
calendarStrip.setItemSelectionListener(new SwipeableCalendarStripListener() {
    @Override
    public void onCalendarStripItemSelected(String value, String type) {
    }
});
```
### Kotlin
```kotlin
calendarStrip.itemSelectionListener = object : SwipeableCalendarStripListener {
            override fun onCalendarStripItemSelected(value: String, type: String) {
            }
        }
```

## Customization
You can customize SwipeableCalendarStripView programmatically in your Activity or Fragment through its **Builder**:

### Java
```java
SwipeableCalendarStrip calendarStrip = 
        new SwipeableCalendarStrip.Builder(view, R.id.cv_calendar_strip)
                .itemCount(10) // The total number of items in the component
                .typeface(...) // Item text font
                .displayMode(SwipeableCalendarStrip.DisplayMode.MONTHS_YEARS) // Date format
                .itemTextSize(...) // Item text size
                .itemTextColor(...) // Item text color
                .build();
```
### Kotlin
```kotlin
val calendarStrip = SwipeableCalendarStrip.Builder(view!!, R.id.cv_calendar_strip)
                .itemCount(10) // The total number of items in the component
                .typeface(...) // Item text font
                .displayMode(SwipeableCalendarStrip.DisplayMode.MONTHS_YEARS) // Date format
                .itemTextSize(...) // Item text size
                .itemTextColor(...) // Item text color
                .build()
```
