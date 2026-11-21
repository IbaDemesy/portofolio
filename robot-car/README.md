# Raspberry Pi Robot Car

A Raspberry Pi robot-car project with motor control, a Flask web interface, camera-based ArUco detection and a laser-cut chassis design.

## Context

Télécom Paris engineering coursework. The project year is not recorded in the repository.

## What it includes

- Manual and autonomous control routines in `page_web/Raspwebinterface2.py`.
- PCA9685 motor control in `page_web/PCA9685.py`.
- Camera and ArUco marker detection using OpenCV.
- A laser-cut design in `design_laser/Vroum_VF.dxf`.
- Earlier experiments and versions in `archives/`.

## Tech stack

Python, Flask, NumPy, OpenCV, PCA9685 over I²C, HTML, CSS and JavaScript.

## How to run

On a configured Raspberry Pi with the motor controller, camera, Python packages and network settings in place, run `python page_web/Raspwebinterface2.py` from this folder. The script starts its web server and camera/control threads immediately; review its configured host address and camera device path for the local setup before launching.

## Folder contents

- `page_web/` — current web-control implementation and static assets.
- `archives/` — earlier control, camera and motor experiments.
- `design_laser/` — laser-cut design file.
