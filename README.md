# Econometrics Project

An econometrics course project completed at Télécom Paris in November 2024 by Cyprien Braunwald and Iba Demesy. The notebook combines a cross-sectional analysis of the HPRICE2 housing dataset with time-series exercises using the `threecenturies_v2.3.xlsx` workbook.

## What's inside

| File | Description |
| --- | --- |
| `Econometrics-project.ipynb` | Course questions, code and analysis |
| `HPRICE2.raw` | HPRICE2 cross-sectional data |
| `threecenturies_v2.3.xlsx` | Workbook used for the time-series section |
| `Projet NOV 2024.docx` | Project brief |

## Methods

- Cross-sectional OLS regressions, coefficient significance tests and joint F-tests
- Log transformations, heteroskedasticity analysis and weighted least squares
- Augmented Dickey–Fuller stationarity tests, moving-average detrending, differencing, and ACF/PACF plots
- Residual autocorrelation checks and feasible GLS with an AR(1) error structure
- Lagged regressions, a Granger-causality F-test and Chow tests for coefficient stability

## Tech stack

Python, Jupyter, NumPy, pandas, Matplotlib, statsmodels and SciPy.

## How to run

Install the notebook and analysis dependencies:

```bash
python -m pip install jupyter numpy pandas matplotlib statsmodels scipy openpyxl
```

Open `Econometrics-project.ipynb` in Jupyter and run its cells in order. The notebook loads both datasets from GitHub raw URLs, so execution requires an internet connection; local copies of the data are also included in this repository.

## Authors and context

Cyprien Braunwald and Iba Demesy, Télécom Paris econometrics course project, November 2024.
