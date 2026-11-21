# Econometrics Project

A Télécom Paris econometrics project combining cross-sectional housing analysis with historical time-series exercises.

## Context

Télécom Paris econometrics course, November 2024. Authors: Cyprien Braunwald and Iba Demesy.

## What it includes

- Cross-sectional OLS, coefficient and joint F-tests, log transformations, heteroskedasticity analysis and weighted least squares.
- Time-series stationarity tests, moving-average detrending, differencing, ACF/PACF plots, AR(1) feasible GLS, Granger-causality and Chow tests.

## Tech stack

Python, Jupyter, NumPy, pandas, Matplotlib, statsmodels, SciPy and openpyxl.

## How to run

Install the notebook dependencies:

```bash
python -m pip install jupyter numpy pandas matplotlib statsmodels scipy openpyxl
```

Start Jupyter from this folder, open `Econometrics-project.ipynb` and run its cells in order. It reads the included `HPRICE2.raw` and `threecenturies_v2.3.xlsx` files; no source-repository URL is required.

## Folder contents

- `Econometrics-project.ipynb` — course questions, analysis and results.
- `HPRICE2.raw` — HPRICE2 cross-sectional data.
- `threecenturies_v2.3.xlsx` — time-series workbook.
- `Projet NOV 2024.docx` — course project brief.
