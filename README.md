# ModalEx

Android provides so many ways to deliver a modal message.
They are all extensible and below are some exercises of some.

<img width="200" src="https://user-images.githubusercontent.com/1282659/107152036-65f50a00-692b-11eb-83f1-6747fb92f737.png">

### Floating View -> WindowManager

Insert a top most view directly via WindowManager; thanks to code snipet in StackOverflow by Phan<sup>[1]</sup>.  \
User permission is required.

<img width="200" src="https://user-images.githubusercontent.com/1282659/107150765-24f9f700-6925-11eb-8b84-0afda601c856.png"> <img width="200" src="https://user-images.githubusercontent.com/1282659/107150767-262b2400-6925-11eb-8702-17f9ca14ce34.png">

### AlertDialog

Basic alertDialog, nice click anywhere feature by default.  
See my theme exercise<sup>[2]</sup> for styling.  

<img width="200" src="https://user-images.githubusercontent.com/1282659/107152033-655c7380-692b-11eb-83ca-faef7bbd01a1.png"> 

### DialogFragment

A step up from the alertDialog is DialogFragment. \
It has the dark translucent background but no default click handler.

<img with="200" src="https://user-images.githubusercontent.com/1282659/107158997-1fb3a100-6953-11eb-9713-6ebc24f3ed25.png">

### Toast

A toast message with gravity set to top.

<img width="200" src="https://user-images.githubusercontent.com/1282659/107152371-18799c80-692d-11eb-9c8d-ce62d04b1eba.png">

### Snackbar 

A Material design replacement of toast. \
Default at the bottom like a toast; placement and style adjustable. 

<img width="200" src="https://user-images.githubusercontent.com/1282659/107158343-00b31000-694f-11eb-9dfb-18f804195448.png"> <img width="200" src="https://user-images.githubusercontent.com/1282659/107158344-014ba680-694f-11eb-80b7-da926bd2ea39.png">


# References

1. StackOverflow: What is WindowManager in Android, Phan Van Linh, October 20, 2017 \
https://stackoverflow.com/questions/19846541/what-is-windowmanager-in-android

2. AndroidThemeEx, C.T. Yeung \
https://github.com/yeuchi/AndroidThemeEx

3. StackOverflow: How to fix the Snackbar height and position, Alexandr Larin and others, 2017 \
https://stackoverflow.com/questions/41300937/how-to-fix-the-snackbar-height-and-position

