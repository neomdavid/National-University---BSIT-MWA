# Registrar Queue System

The project's main requirement was to develop a system that addresses a real-life issue. After observing our university, I identified potential enhancements in the queueing system at the Registrar's Office, leading to the creation of this system. The documentation for this project has been uploaded within this folder.


![](https://github.com/neomdavid/National-University---BSIT-MWA/blob/main/First%20Year/Third%20Term/RegistrarQueueGIF.gif)

# Registrar Queue System

## I. General Requirements

### A. General Description
When students need to request an academic record or document from the Registrar’s Office, they typically do so by visiting the school. However, due to limited capacity, the Registrar's Office can only accommodate the first 25 walk-in guests each day. The Queueing Information System is designed to help students be aware of the transactions left for on-site document requests and keep track of the requested documents. The system will also enable the Registrar to display requested documents readiness and schedule the pick-up date for requested documents.

### B. General Features

1. **Walk-in Request Registration:**
    To provide students with information whether they can request a document on-site, this feature displays the number of transactions remaining for the day. Students will be able to see whether they can still request a document from the Registrar’s Office on a day or not. This feature also allows the Registrar to add a client to the system for every on-site transaction with the client’s information:
    - Student’s name
    - Student’s contact number
    - Type of requested document of the student
    - Date of application of document request
    Once a client is added, the system generates a unique reference number–in this format: “YYYY-client number” (e.g. “2023-01”)–that the student can use to track the progress of their document request.

2. **Transaction Monitoring:**
    The transaction monitoring enables the Registrar to set the readiness status of a requested document. The Registrar can set whether the requested document is already ready or not and they can set the pick-up date for the document requested by the client. If the requested document is ready, the Registrar can set a pick up date for the document; otherwise, the requested document’s status will remain unavailable.

3. **Reference Number Tracker:**
    Once a student is given a reference number after an on-site transaction, this feature allows them to track the progress of their request. If a student tracks their reference number, the system will display the following details about the updated information of the student’s requested document:
    - Name of the student
    - Readiness of the requested document
    - Pick up date of the requested document


