@echo off
title this is the scheduler batch script

SCHTASKS /Create /TN WallpaperUpdater /TR "%~dp0RedditImageFetch.py %1 %2" /sc DAILY

SCHTASKS /Run /TN WallpaperUpdater

pause

