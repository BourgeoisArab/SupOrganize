@echo off
title this is the scheduler batch script

SCHTASKS /Create /TN WallpaperUpdater /TR "dirmanager.bat %1 %2 %3" /sc DAILY
 
SCHTASKS /Run /TN WallpaperUpdater

pause