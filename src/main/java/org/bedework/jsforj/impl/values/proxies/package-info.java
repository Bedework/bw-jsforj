/**
 * User: mike Date: 8/19/20 Time: 22:20
 * <p>This package defines classes which proxy for collections mostly
 * </p>
 *
 * <p>The proxy is provided with three items of information,
 * any or all of which may be null:<ul>
 * <li>a master collection</li>
 * <li>an override collection</li>
 * <li>an update list in the form of JsonPointer objects</li>
 * </ul>
 * and will provide a view of the master modified by the other two.
 * </p>
 *
 * <p>The update list entries must all have the head element removed.
 * For example if we have "/locations/12345/..." and
 * "/locations/abcd/..." then what is passed is "/12345/..." and
 * "/abcd/..."</p>
 *
 * <p>This implements the override and locale features in jscalendar
 * which may consist of full replacement objects, e.g. a heavily modified
 * attendee, or one or more patches, e.g. modifying the participation
 * status only.</p>
 *
 * <p>
 *   Adding an element to the collection will trigger the creation of
 *   the override collection if it doesn't exist.
 * </p>
 *
 * <p>
 *   Removing an element from the collection will trigger the removal of
 *   the override collection if it is now empty.
 * </p>
 *
 * <p>
 *   Updating an element in the collection will cause an add to the
 *   proxy.
 * </p>
 */
package org.bedework.jsforj.impl.values.proxies;
