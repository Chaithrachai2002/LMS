package com.gigasea.learning_management.service;

import com.gigasea.learning_management.model.Attendance;
import java.util.List;

public interface AttendanceService {

    /**
     * Saves or updates an attendance record.
     *
     * @param attendance the attendance record to be saved or updated.
     */
    void saveAttendance(Attendance attendance);

    /**
     * Retrieves all attendance records.
     *
     * @return a list of all attendance records.
     */
    List<Attendance> findAttendances();

    /**
     * Retrieves an attendance record by its ID.
     *
     * @param id the ID of the attendance record.
     * @return the attendance record with the specified ID.
     */
    Attendance getAttendanceById(Long id); // Renamed for clarity

    /**
     * Deletes an attendance record by its ID.
     *
     * @param id the ID of the attendance record to delete.
     */
    void deleteAttendance(Long id);

    /**
     * Deletes all attendance records from the database.
     */
    void deleteAllAttendances();

    /**
     * Counts the total number of attendance records.
     *
     * @return the total number of attendance records.
     */
    long countAttendances(); // Added for admin statistics and reporting
}
