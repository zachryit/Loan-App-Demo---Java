# Salary Advance Endpoint

## Example Request

`POST /api/salary-advance`

```json
{
  "employeeEmail": "staff@company.com",
  "amount": 2500,
  "tenureMonths": 6
}
```

## Example Response

```json
{
  "applicationId": "LN-1000",
  "status": "PENDING",
  "monthlyDeduction": 416.67
}
```
