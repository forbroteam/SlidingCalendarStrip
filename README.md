# SlidingCalendarStrip
Easy to use scrollable, horizontal calendar strip component library for Android, written in Kotlin

## Prerequisites
The minimum API level supported by this library is **API 17**.

## Usage
Add SlidingCalendarView to your layout file:

```xml
<com.forbroteam.slidingcalendarstrip.SlidingCalendarView
        android:id="@+id/cv_sliding_calendar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#5a31ac" />
```        
Then setup SlidingCalendarView in your Activity or Fragment through its **Builder**:
   
```java
SlidingCalendar calendar = new SlidingCalendar.Builder(view, R.id.cv_sliding_calendar).build();
```

Then set a listener:

```java
calendar.setItemSelectionListener(new SlidingCalendarListener() {
    @Override
    public void onSlidingCalendarItemSelected(@NotNull String value, @NotNull String type) {

    }
});
```
## Customization
You can customize SlidingCalendarView programmatically in your Activity or Fragment through its **Builder**:

```java
SlidingCalendar calendar = new SlidingCalendar.Builder(view, R.id.cv_sliding_calendar)
                .itemCount(10) // The total number of items in the component
                .typeface(...) // Item text font
                .displayMode(SlidingCalendar.DisplayMode.MONTHS_YEARS) // Date format
                .itemTextSize(...) // Item text size
                .itemTextColor(...) // Item text color
                .build();
```
