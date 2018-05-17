
@echo off
if NOT exist dummy.txt (
	copy NUL dummy.txt
	<nul set /p="00000000000000000000" > dummy.txt
	for /L %%i in (1,1,23) do type dummy.txt >> dummy.txt	
)
set /p binarylimit="Enter number of gigabytes to write: ":
set /a binaryLimit="binaryLimit * 4"
for /l %%i in (1,1,%binarylimit%) do (
	echo file%%i
	if NOT exist dummy%%i.txt (
		type dummy.txt >> dummy%%i.txt
	)
	
)
pause
