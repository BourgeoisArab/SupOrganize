@echo off
title this is the scheduler batch script

SCHTASKS /Create /TN WallpaperUpdater /TR "%~dp0test.py %1" /sc DAILY

SCHTASKS /Run /TN WallpaperUpdater

pause

