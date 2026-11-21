# Factory Simulator

A Java canvas application that models a factory floor with rooms, mobile robots, storage, charging points, a conveyor and a production unit.

## Context

Télécom Paris engineering coursework. The project year is not recorded in the repository.

## What it includes

- A simulator entry point at `USINE_I_V/src/Test/SimulatorApplication.java`.
- Factory areas, robots, pucks and charging points in the `Test` package.
- A canvas data file in `USINE_I_V/data/FactoryCanva.canvas`.
- The existing project note flags the production-unit implementation as buggy.

## Tech stack

Java and the Télécom Paris Canvas library (`USINE_I_V/libs/canvas-viewer.jar`).

## How to run

Open `USINE_I_V` as a Java project in an IDE, configure the canvas library dependencies, and run `Test.SimulatorApplication`. The repository includes `canvas-viewer.jar`; any additional Télécom Paris Canvas API dependencies must be available on the project classpath.

## Folder contents

- `USINE_I_V/src/Test/` — simulator and canvas model classes.
- `USINE_I_V/config/` — launch and logging configuration.
- `USINE_I_V/data/` — saved factory canvas.
- `USINE_I_V/libs/` — canvas viewer library.
