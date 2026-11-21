# Télécom Paris Engineering Projects

A collection of engineering coursework projects developed at Télécom Paris, spanning a Raspberry Pi robot car, a Java factory simulator and movie-data analysis notebooks.

## What's inside

| Project | Contents |
| --- | --- |
| `teame-main/` | Raspberry Pi robot-car code with PCA9685 motor control over I²C, a Flask web control interface, OpenCV ArUco marker recognition and a laser-cut design (`design_laser/Vroum_VF.dxf`). |
| `usine robot/` | Java factory and robot simulator with rooms, robots, conveyors, storage, charging points and a production unit. The canvas application uses the Télécom Paris canvas library. |
| `Data analysis 1/` | Jupyter notebooks and datasets for IMDb and box-office data collection and analysis, including movie, actor and role data. |

## Tech stack

- Python, Flask, OpenCV, NumPy and PCA9685/I²C hardware
- Java and the Télécom Paris canvas library
- Jupyter, pandas and Matplotlib; Selenium and WebDriver Manager in the data-collection notebooks

## How to run

- Open the notebooks in `Data analysis 1/` with Jupyter. The collection notebooks use Selenium and require a compatible Chrome browser and WebDriver; the analysis notebooks use the included datasets.
- The robot code is hardware-dependent. On a configured Raspberry Pi with the PCA9685 board, camera and required Python packages connected, run `python teame-main/page_web/Raspwebinterface2.py`. Review its network and hardware configuration before use.
- To run the simulator, open `usine robot/USINE_I_V` in a Java IDE, add `libs/canvas-viewer.jar` and the required Télécom Paris canvas library dependencies to the classpath, then launch `Test.SimulatorApplication`.

## Authors and context

Repository owner: Iba Demesy. These projects come from engineering coursework at Télécom Paris and include work from different courses and teams.