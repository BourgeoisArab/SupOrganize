@echo off
title this is the scheduler batch script

SCHTASKS /Create /TN WallpaperUpdater /TR "%3\dirmanager.bat %1 %2 %3" /SC ONLOGON 

%3\dirmanager.bat %1 %2 %3

pause

